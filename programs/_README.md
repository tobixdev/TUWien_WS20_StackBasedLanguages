# How to create new test cases

* Create a .java file with the desired code
* Invoke `javac XYZ.class` on that code
* Use `javap -v XYZ.class` to see the intermediate representation.
* Copy the method under test into an XYZ.ps file and clean up meta data (comments & line numbers eg)

# Addtional Bytes

Additional bytes are added as stack value. Some examples.

* `(add)` no additional bytes
* `(iload) 0` one additional bytes
* `(goto) 1 255 ` two additional bytes, where 1 is the first additional byte and 255 is the second additional byte