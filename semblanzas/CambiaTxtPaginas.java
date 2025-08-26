import java.io.*;
import java.util.*;

public class CambiaTxtPaginas
{
 public static void main(String[] args) throws Exception
  {
   if(args.length==3)
    {
     int i=0;
     String line="", fileName="tmp_"+i+".txt";
     File tmpFile = new File(fileName), tobeDeleted=new File(args[0]);
     while(tmpFile.exists())
      {
       i=i+1;
       fileName="tmp_"+i+".txt";
       tmpFile.renameTo(new File(fileName));
      }
     List<String> lines = new ArrayList<>();
     BufferedReader infile = new BufferedReader(new FileReader(args[0]));
     
     while((line=infile.readLine())!=null)
      {
       lines.add(line.replaceAll(args[1], args[2])); 
      }
     infile.close();

     BufferedWriter outfile = new BufferedWriter(new FileWriter(fileName));
     for(i=0; i<lines.size(); i++)
      {
       line=(String)lines.get(i);
       outfile.write(line);
       outfile.newLine();
      }
     outfile.flush();
     outfile.close();

     tobeDeleted.delete();
     tmpFile.renameTo(new File(args[0]));
    }
   else
    {
     System.err.println("Usage:\njava CambiaTxtPaginas <infile> <txt1> <txt2>");
     System.err.println("<infile> file where to substitute txt; e.g., index.html.");
     System.err.println("<txt1> text to be substituted in <infile>; e.g., \"Asociaci&oacute;n de Alumni de la Fundaci&oacute;n Alexander von Humboldt en M&eacute;xico\".");
     System.err.println("<txt2> text that will substitute <txt1>; e.g., \"Asociaci&oacute;n de exbecarios y premiados de la Fundaci&oacute;n Alexander von Humboldt en M&eacute;xico\".");
     System.err.println("The program will re-write <infile>, sunbstituting <txt1> for <txt2> in the whole document.");
     System.err.println("");
     System.err.println("");
    }
  }
}
