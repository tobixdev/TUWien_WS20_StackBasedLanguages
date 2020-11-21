# How to create new test cases

- Create a .java file with the desired code
- Invoke `javac XYZ.class` on that code
- Use `javap -v XYZ.class` to see the intermediate representation.
- Copy the method under test into an XYZ.sbyte (simple byte code) and clean up meta data (comments & line numbers eg)