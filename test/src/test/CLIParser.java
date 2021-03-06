package test;

import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CLIParser {

	private static final String LEFT_PADDING = "      "; 
	 
    private String cliName; 
    private String[] cliHelp; 
    private Map<String, Options> commands = new LinkedHashMap<String, Options>(); 
    private Map<String, Boolean> commandWithArgs = new LinkedHashMap<String, Boolean>(); 
    private Map<String, String> commandsHelp = new LinkedHashMap<String, String>(); 
 
    /**
     * Create a parser. 
     * 
     * @param aCliName name of the parser, for help purposes. 
     * @param aCliHelp help for the CLI. 
     */ 
    public CLIParser(String aCliName, String[] aCliHelp) { 
        this.cliName = aCliName; 
        this.cliHelp = aCliHelp.clone(); 
    } 
 
    /**
     * Add a command to the parser. 
     * 
     * @param command        comand name. 
     * @param argsHelp       command arguments help. 
     * @param commandHelp    command description. 
     * @param commandOptions command options. 
     * @param hasArguments   has args 
     */ 
    public void addCommand(String command, String argsHelp, String commandHelp, Options commandOptions, 
                           boolean hasArguments) { 
        String helpMsg = argsHelp + ((hasArguments) ? "<ARGS> " : "") + ": " + commandHelp; 
        commandsHelp.put(command, helpMsg); 
        commands.put(command, commandOptions); 
        commandWithArgs.put(command, hasArguments); 
    } 
 
    /**
     * Bean that represents a parsed command. 
     */ 
    public static final class Command { 
        private String name; 
        private CommandLine commandLine; 
 
        private Command(String name, CommandLine commandLine) { 
            this.name = name; 
            this.commandLine = commandLine; 
        } 
 
        /**
         * Return the command name. 
         * 
         * @return the command name. 
         */ 
        public String getName() { 
            return name; 
        } 
 
        /**
         * Return the command line. 
         * 
         * @return the command line. 
         */ 
        public CommandLine getCommandLine() { 
            return commandLine; 
        } 
    } 
 
    /**
     * Parse a array of arguments into a command. 
     * 
     * @param args array of arguments. 
     * @return the parsed Command. 
     * @throws ParseException thrown if the arguments could not be parsed. 
     */ 
    public Command parse(String[] args) throws ParseException { 
        if (args.length == 0) { 
            throw new ParseException("missing sub-command"); 
        } else { 
            if (commands.containsKey(args[0])) { 
                GnuParser parser = new GnuParser(); 
                String[] minusCommand = new String[args.length - 1]; 
                System.arraycopy(args, 1, minusCommand, 0, minusCommand.length); 
                return new Command(args[0], parser.parse(commands.get(args[0]), minusCommand, 
                        commandWithArgs.get(args[0]))); 
            } else { 
                throw new ParseException(MessageFormat.format("invalid sub-command [{0}]", args[0])); 
            } 
        } 
    } 
 
    public String shortHelp() { 
        return "use 'help' sub-command for help details"; 
    } 
 
    /**
     * Print the help for the parser to standard output. 
     */ 
    public void showHelp() { 
        PrintWriter pw = new PrintWriter(System.out); 
        pw.println("usage: "); 
        for (String s : cliHelp) { 
            pw.println(LEFT_PADDING + s); 
        } 
        pw.println(); 
        HelpFormatter formatter = new HelpFormatter(); 
        for (Map.Entry<String, Options> entry : commands.entrySet()) { 
            String s = LEFT_PADDING + cliName + " " + entry.getKey() + " "; 
            if (entry.getValue().getOptions().size() > 0) { 
                pw.println(s + "<OPTIONS> " + commandsHelp.get(entry.getKey())); 
                formatter.printOptions(pw, 100, entry.getValue(), s.length(), 3); 
            } else { 
                pw.println(s + commandsHelp.get(entry.getKey())); 
            } 
            pw.println(); 
        } 
        pw.flush(); 
    }

}
