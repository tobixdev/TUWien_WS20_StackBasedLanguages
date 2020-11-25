# How to create new test cases

* Create a .java file with the desired code
* Invoke `javac XYZ.class` on that code
* Use `javap -v XYZ.class` to see the intermediate representation.
* Copy the method under test into an XYZ.ps file and clean up meta data (comments & line numbers eg)

# Addtional Bytes

Additional bytes are added as stack value. Some examples.

* `(add)` no additional bytes
* `0 (iload)` one additional bytes
* `1 255 (goto)` two additional bytes, where 255 is the second additional byte and 1 is the first additional byte