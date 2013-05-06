package com.abstractthis.asciiart.widget;

//The MIT License (MIT)
//
//Copyright (c) 2013 David Smith <www.abstractthis.com>
//
//Permission is hereby granted, free of charge, to any person obtaining a copy
//of this software and associated documentation files (the "Software"), to deal
//in the Software without restriction, including without limitation the rights
//to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//copies of the Software, and to permit persons to whom the Software is
//furnished to do so, subject to the following conditions:
//
//The above copyright notice and this permission notice shall be included in
//all copies or substantial portions of the Software.
//
//THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
//THE SOFTWARE.

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
