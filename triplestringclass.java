/*______________________________________________________________________________________________*/
/*  Name: Ellis Sentoso
 *  Instructor: Dave Harden
 *  Assignment: Lab 6 - A Triple String Class
 *  Description: This is a simple program which implements a class with two ctors, 
 *  accessors, mutators, and private helper methods. It seeks to look into how Java
 *  processes classes
 *  Email: ellissentoso@gmail.com
 *  Date: 07/22/2019  
/*______________________________________________________________________________________________*/


// package assignment6;

public class Foothill {
  public static void main(String[] args) {
    TripleString [] obj = new TripleString [4]; // declare an array TripleString objects

    // step 1
    System.out.println("Instantiate four or more TripleString objects");
    obj[0] = new TripleString();  // default
    obj[1] = new TripleString();  // default
    obj[2] = new TripleString ("abc", "efg", "");  // partly good ctor
    obj[3] = new TripleString ("wer", "fghh", "rpg");  // all good ctor

    // step 2
    for (int i = 0; i < 4; i++) {
      System.out.println("obj" + (i + 1) + ":");
      System.out.println(obj[i].getString1());
      System.out.println(obj[i].getString2());
      System.out.println(obj[i].getString3());
    }

    // step 3
    System.out.println();
    System.out.println("Mutate one or more members of every object");
    obj[1].setString1("");    // expected to fail
    obj[1].setString2("itsok");  // expected to work

    // step4
    for (int i = 0; i < 4; i++) {
      System.out.println("obj" + (i + 1) + ":");
      System.out.println(obj[i].getString1());
      System.out.println(obj[i].getString2());
      System.out.println(obj[i].getString3());
    }

    // step 5
    System.out.println();
    System.out.println("Do two explicit mutator tests");

    // expected to fail
    if (obj[0].setString1("012345678901234567890123456789012345678901234567890123")) {
      System.out.println("obj[0].setString1 good");
    }
    else {
      System.out.println("obj[0].setString1 failed");
    }

    // expected to work
    if (obj[1].setString3("0123")) {
      System.out.println("obj[1].setString3 good");
    }
    else {
      System.out.println("obj[3].setString3 failed");
    }

    // step 6
    System.out.println();
    System.out.println("Make two accessor calls to demonstrate that they work");
    System.out.println("obj[0]" + obj[0].toString());
    System.out.println("obj[1]" + obj[1].toString());
  }
}
/*______________________________________________________________________________________________*/

class TripleString {
  // Private Class Instance Members
  private String string1;
  private String string2;
  private String string3;

  // Public Class Static Constants
  public static final int MAX_LEN = 50;
  public static final int MIN_LEN = 1;
  public static final String DEFAULT_STRING = " (undefined) ";

  // A default ctor which initializes all variables to DEFAULT_STRING
  public TripleString() {
    string1 = DEFAULT_STRING;
    string2 = DEFAULT_STRING;
    string3 = DEFAULT_STRING;
  }
/*______________________________________________________________________________________________*/

  // A constructor that initializes all members according to the passed parameters. 
  // If not valid, it will change the corresponding one to DEFAULT_STRING
  public TripleString(String str1, String str2, String str3) {
    if (validString(str1)) {
      string1 = str1;
    }
    else {
      string1 = DEFAULT_STRING;
    }
    if (validString(str2)) {
      string2 = str2;
    }
    else {
      string2 = DEFAULT_STRING;
    }
    if (validString(str3)) {
      string3 = str3;
    }
    else {
      string3 = DEFAULT_STRING;
    }
  }
/*______________________________________________________________________________________________*/
  // A mutator for string1 which changes it to str if valid. If not valid, adopts no action
  public boolean setString1( String str ) {
    if (validString(str)) {
      string1 = str;
      return true;
    }
      return false;
  }
/*______________________________________________________________________________________________*/

  // A mutator for string2 which changes it to str if valid. If not valid, adopts no action
  public boolean setString2( String str ) {
    if (validString(str)) {
      string2 = str;
      return true;
    }
      return false;
  }
/*______________________________________________________________________________________________*/

  // A mutator for string3 which changes it to str if valid. If not valid, adopts no action
  public boolean setString3( String str ) {
    if (validString(str)) {
      string3 = str;
      return true;
    }
      return false;
  }
/*______________________________________________________________________________________________*/

  // An accessor for string1
  public String getString1() {
      return string1;
  }
/*______________________________________________________________________________________________*/

  // An accessor for string2
  public String getString2() {
      return string2;
  }
/*______________________________________________________________________________________________*/

  // An accessor for string3
  public String getString3() {
      return string3;
  }
/*______________________________________________________________________________________________*/

  // An accessor for all strings in the form of "string1: string2: string3: "
  public String toString() {
    String str1, str2, str3;

    // it will give "null" if it is a null String
    if (string1 == null) {
      str1 = "null";
    }
    else {
      str1 = string1;
    }
    if (string2 == null) {
      str2 = "null";
    }
    else {
      str2 = string2;
    }
    if (string3 == null) {
      str3 = "null";
    }
    else {
      str3 = string3;
    }

    return "string1: " + str1 + " string2: " + str2 + " string3: " + str3;
  }
/*______________________________________________________________________________________________*/

  // Private helper method to determine if it is valid
  private boolean validString( String str ) {
    // If null, return false
    if (str == null)
      return false;
    // If not, return if str is within the range
    return (str.length() >= MIN_LEN && str.length() <= MAX_LEN);
  }
}

/*--------- Sample Run -----------------------------------
Instantiate four or more TripleString objects
obj1:
 (undefined)
 (undefined)
 (undefined)
obj2:
 (undefined)
 (undefined)
 (undefined)
obj3:
abc
efg
 (undefined)
obj4:
wer
fghh
rpg

Mutate one or more members of every object
obj1:
 (undefined)
 (undefined)
 (undefined)
obj2:
 (undefined)
itsok
 (undefined)
obj3:
abc
efg
 (undefined)
obj4:
wer
fghh
rpg

Do two explicit mutator tests
obj[0].setString1 failed
obj[1].setString3 good

Make two accessor calls to demonstrate that they work
obj[0]string1:  (undefined)  string2:  (undefined)  string3:  (undefined)
obj[1]string1:  (undefined)  string2: itsok string3: 0123

*/
