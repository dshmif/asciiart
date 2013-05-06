package com.abstractthis.asciiart.widget;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import com.abstractthis.consoul.widgets.Widget;

public class AsciiArtWidget implements Widget {
	private static final String ASCII_ART_DIR = System.getProperty("user.dir") + "/art/";
	private static final int BUFFER_SIZE = 1024 * 2;
	private final String ASCII_ART_FILENAME;
	
	private final InputStream is;
			
	
	public AsciiArtWidget(String artFilename) {
		this.ASCII_ART_FILENAME = artFilename;
		try {
			is = new FileInputStream(new File(ASCII_ART_DIR + ASCII_ART_FILENAME));
		}
		catch(IOException ioe) {
			String msg = String.format("ascii art file 404 [%s]", ASCII_ART_DIR + ASCII_ART_FILENAME);
			throw new RuntimeException(msg);
		}
	}

	@Override
	public void render(PrintStream out) {
		try {
			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead = 0;
			while ((bytesRead = is.read(buffer)) != -1) {
				out.write(buffer, 0, bytesRead);
			}
		}
		catch(IOException ioe) {
			String msg = String.format("Failed to render ascii art in %s", ASCII_ART_FILENAME);
			throw new RuntimeException(msg, ioe);
		}
		finally {
			if (is != null) {
				try { is.close(); }
				catch(IOException ioe) { /* NOP */ }
			}
		}
		
	}

}
