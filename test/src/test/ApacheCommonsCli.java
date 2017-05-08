package test;

import org.apache.commons.cli.AlreadySelectedException;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class ApacheCommonsCli {

	public static void main(String[] args) {
		
		
		String[] arguments = {"-create","-pfsServer","serverName"};
		
		
		try {
			Option create = new Option("create", "create action");
			Option pfsServer = new Option("pfsServer", true, "pfs server name");
			
			Option update = new Option("update", "update action");
			Option serverName = new Option("serverName", "the server name to be updated!");
			
			OptionGroup createOG = new OptionGroup();
			createOG.addOption(create);
			createOG.addOption(pfsServer);
			
			OptionGroup updateOG = new OptionGroup();
			updateOG.addOption(update);
			updateOG.addOption(serverName);
			
			Options options = new Options();
			options.addOptionGroup(createOG);
			options.addOptionGroup(updateOG);
			
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp( "PFSConfig", options );
			
			CommandLineParser parser = new DefaultParser();
			CommandLine cmd = parser.parse(options, arguments);
			for(Option opt : cmd.getOptions()) {
				System.out.println(opt.getOpt());
				if(opt.hasArg()) {
					System.out.println(opt.getValue());
				}
				
			}
			
		} catch (AlreadySelectedException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			
		}

	}

}
