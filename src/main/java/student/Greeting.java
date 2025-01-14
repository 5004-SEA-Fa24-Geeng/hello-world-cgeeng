package student;

/**
 * The greeting class is one students will build from scratch. You can use the javadoc to help guide
 * the building of the class. Until this class is built, the autograder will not be available/fail
 * to run.
 *
 * <p>
 * The greeting class stores the locality ID, locality name, and a string format of the greeting
 * both ascii and unicode. That way the various ways to look at the greeting are paired together,
 * which could simplify the process of looking up the greeting making it easier to add additional
 * greeting types without having to change code in other places.
 * </p>
 *
 * <p>
 * For HW01 you won't have to explore how to do that, but you are encouraged to about how you could
 * integrate this class to make the final program more versatile.
 * </p>
 *
 * <p>
 * The following examples are ways the class can be built and used:
 * </p>
 *
 *
 *
 * <pre>
 * {@code
 * Greeting g = new Greeting(2, "English"); // sets up greeting to be "Hello, {name}!"
 * Greeting h = new Greeting(1, "Hawaii", "Aloha"); // setups up greeting to be "Aloha, {name}!"
 * Greeting c = new Greeting(3, "China", "你好", "Ni Hao", "%%s, %s!"); // sets up greeting to be
 *                                                                    // "{name}, 你好!"
 *
 * }
 * </pre>
 *
 *
 */
public class Greeting {

    /** LocalityID. */
    private final int localityID;
    /** Locality Name. */
    private final String localityName;
    /** greeting using only ascii characters. */
    private final String asciiGreeting;
    /** greeting using unicode characters. */
    private final String unicodeGreeting;
    /** format string for the greeting, needs to have a %%s so the name can be inserted. */
    private final String formatStr;


    /**
     * Default greeting that creates "Hello, {name}!".
     *
     * @param localityID id of the locality
     * @param localityName name of the locality
     */
    public Greeting(int localityID, String localityName) {
        this(localityID, localityName, "Hello");
    }

    /**
     * Greeting that creates a greeting with ascii and unicode characters assuming the language is
     * already using ascii letters only. It also assumes the format of the greeting to be
     * "{greeting}, {name}!"
     *
     * <p>
     * For the default format string you will want to use "%s, %%s!" which places the greeting
     * before the persons potential name.
     * </p>
     *
     * @param localityID id of the locality
     * @param localityName name of the locality
     * @param greeting greeting using ascii characters
     */
    public Greeting(int localityID, String localityName, String greeting) {
        this(localityID, localityName, greeting, greeting, "%s, %%s!");
    }

    /**
     * Greeting that creates a greeting with ascii and unicode characters. It makes no assumptions
     * and everything needs to be provided.
     *
     * <p>
     * Often the other constructors will call this very detailed constructor. Using the following
     * code (as an example this is the code for one of the constructors).
     * </p>
     *
     * <pre>
     * public Greeting(int localityID, String localityName, String greeting) {
     *     this(localityID, localityName, greeting, greeting, "%s, %%s!");
     * }
     * </pre>
     *
     * @param localityID id of the locality
     * @param localityName name of the locality
     * @param asciiGreeting greeting using ascii characters
     * @param unicodeGreeting greeting using unicode characters
     * @param formatStr format string for the greeting
     */
    public Greeting(int localityID, String localityName, String asciiGreeting,
                    String unicodeGreeting, String formatStr) {
        this.localityID = localityID;
        this.localityName = localityName;
        this.asciiGreeting = asciiGreeting;
        this.unicodeGreeting = unicodeGreeting;
        this.formatStr = formatStr;
    }

    /**
     * Returns the locality id number.
     *
     * @return the locality id number
     */
    public int getLocalityID() {
        return localityID;
    }

    /**
     * Returns the locality name.
     *
     * @return the locality name
     */
    public String getLocalityName() {
        return localityName;
    }

    /**
     * Returns the ascii greeting. Just the greeting, no formatting.
     *
     * @return the ascii greeting
     */
    public String getAsciiGreeting() {
        return asciiGreeting;
    }

    /**
     * Returns the unicode greeting. Just the greeting, no formatting.
     *
     * @return the unicode greeting
     */
    public String getUnicodeGreeting() {
        return unicodeGreeting;
    }

    /**
     * Gets the unicode format string. This string will have a %s, so that the name can be inserted
     * into the greeting in the correct location.
     *
     * @return the format string with the greeting inserted into the format
     * @see #getFormatStr(boolean)
     */
    public String getFormatStr() {
        return getFormatStr(false);
    }

    /**
     * Returns the format string with the greeting inserted into the format. This string will have a
     * %s, so that the name can be inserted into the greeting in the correct location.
     *
     * <p>
     * An example use is as follows
     * </p>
     *
     * <pre>
     * {@code
     *
     * Greeting g = new Greeting(2, "English");
     * // later in code
     * String name = "Alice";
     * String greet = String.format(g.getFormatStr(false), name);
     * System.out.println(greet); // Hello, Alice!
     *
     * }
     * </pre>
     *
     *
     * @param asciiOnly if true, only ascii characters will be used
     * @return the format string with the greeting inserted into the format
     */
    public String getFormatStr(boolean asciiOnly) {
        if (asciiOnly) {
            return String.format(formatStr, asciiGreeting);
        } else {
            return String.format(formatStr, unicodeGreeting);
        }
    }

    /**
     * Returns the full greeting details as a string. Primarily for debugging purposes.
     *
     * Example string format:
     *
     * <pre>
     * {localityID:1, localityName:"Hawaii", asciiGreeting:"Aloha", unicodeGreeting:"Aloha"}
     * </pre>
     */
    @Override
    public String toString() {
        return String.format(
                "{localityID:%d, localityName:\"%s\", asciiGreeting:\"%s\", unicodeGreeting:\"%s\"}",
                localityID, localityName, asciiGreeting, unicodeGreeting);
    }

}
