package br.com.usjt.projcontrol.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ServiceCriaLogs {

	public static void criaLogs(String log) throws IOException {
		File arquivo = new File("C:"+ File.separator + "Users" + File.separator + "danie" + File.separator + "workspace" + File.separator + "logs.html");
		Calendar data = Calendar.getInstance();
		
		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}

		List<String> lista = new ArrayList<>();
		lista.add("<html>\r\n" + 
				"<head>\r\n" + 
				"<title>Logs</title>\r\n" + 
				"<body>\r\n" + 
				"	<div style='display:block; margin:auto; width:80vw; height:150px; background-color:lightcoral'>\r\n" + 
				"<h1 style='text-align:center; color:white; font-family:Montserrat; font-weight:bold;'>LOGS " + LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)) + "</h1>" + 
				"	<p style='color:white; font-size:20px; font-family:Montserrat'; text-align:center>" + log + data.get(Calendar.HOUR_OF_DAY) +":" + data.get(Calendar.MINUTE) + ":"+ data.get(Calendar.SECOND) +"</p>\r\n" + 
				"	</div>\r\n" + 
				"</body>\r\n" + 
				"</head>\r\n" + 
				"</html>");

		Files.write(Paths.get(arquivo.getPath()), lista, StandardOpenOption.APPEND);
	}

}
