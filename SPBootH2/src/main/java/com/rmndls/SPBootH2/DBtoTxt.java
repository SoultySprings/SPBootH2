package com.rmndls.SPBootH2;
import com.rmndls.SPBootH2.model.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.*;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DBtoTxt {

    public void writeTxt(String student, String mathMarks, String phyMarks, String chemMarks) throws IOException {
        // Try-with-resources to auto-close FileWriter
        try (FileWriter fw = new FileWriter("changes.txt", true)) {
            // Write character-wise from string
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);
            fw.write(("Current Date and Time: " + formattedDateTime) + "\n"  + "Changes are as follows:\n\n");
            fw.write(student + mathMarks + phyMarks + chemMarks + "\n");
            System.out.println("Changes have been added to changes.txt");
        }
    }

    public void writeDataSQL(student std, mathematics math, physics phy, chemistry chem) throws IOException {

        try (FileWriter fw = new FileWriter("src/main/resources/data.sql", true)) {
            fw.write("INSERT INTO student (rollno, fullname, city) VALUES ("+std.getRollno()+", \'"+std.getFullname()+"\', \'"+std.getCity()+"\');\n");
            fw.write("INSERT INTO mathematics (mno, marks) VALUES ("+math.getMno()+", "+math.getMarks()+");\n");
            fw.write("INSERT INTO physics (pno, marks) VALUES ("+phy.getPno()+", "+phy.getMarks()+");\n");
            fw.write("INSERT INTO chemistry (cno, marks) VALUES ("+chem.getCno()+", "+chem.getMarks()+");\n");
            System.out.println("Added to data.sql!");

        }
    }
}
