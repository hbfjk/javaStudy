package java8.Annotations;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

public class AnnotationTest {

	public static void main(String[] args) {
		Hint hint = Person.class.getAnnotation(Hint.class);
		System.out.println(hint);                   // null
		 
		Hints hints1 = Person.class.getAnnotation(Hints.class);
		System.out.println(hints1.value().length);  // 2
		 
		Hint[] hints2 = Person.class.getAnnotationsByType(Hint.class);
		System.out.println(hints2.length);          // 2

	}

}

@interface Hints {
    Hint[] value();
}

@Repeatable(Hints.class)
@interface Hint {
    String value();
}

//equals to @Hints({@Hint("hint1"), @Hint("hint2")})
@Hint("hint1")
@Hint("hint2")
class Person {}


@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@interface MyAnnotation {}