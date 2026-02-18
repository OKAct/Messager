CC =javac
CV=java



#LDFLAGS="/mnt/c/Visual Studio 2022/HEll/java/SDk/javafx-sdk-25.0.1/lib"


LDFLAGS="/mnt/c/projects/libs/*"

NEW=" user/user.java"




%:
	$(CC) -cp $(LDFLAGS) -d . $@.java
	git add .
	git commit -m "Main Branch"
	clear
	$(CV) -cp $(LDFLAGS) $@.java

#javac --module-path "$pth" --add-modules javafx.controls,javafx.fxml Hello.java
#javac -cp "/mnt/c/projects/libs/*" -d . user/user.java Server.java
#java -cp ".:/mnt/c/projects/libs/*" Server

#javac -cp "/mnt/c/projects/libs/*" Test.java
#java -cp "/mnt/c/projects/libs/*" Test.java
