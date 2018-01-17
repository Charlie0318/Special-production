# adas-security-mqtt/bee-cpabe-sdk-1.0/jni/MQTT-JAVA
 
##
### 1 - After installing JNI,libbee-cpabe.so and libee-cpabe-0.1.so to the MQTT-JAVA. 

### 2 - Use JNI , user need to MQTT/src create class file
	insruction : javac -cp*:. /File absolute path/File name.java
	All files will have a class file.
### 3 - In bee-cpabe-sdk-0.1 instruction [sudo make install].
	libbee-cpabe.so and libbee-cpabe-0.1.so representative file path by $libbee-cpabe.
        Execute file input [java -Djava.library.path= $libbee-cpabe file name]
	Modify the file and then  execute the same instruction can be executed
