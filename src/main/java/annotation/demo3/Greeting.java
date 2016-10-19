package annotation.demo3;

public @interface Greeting {

	  public enum FontColor{ BULE,RED,GREEN};
	    String name();
	    FontColor fontColor() default FontColor.GREEN;
}
