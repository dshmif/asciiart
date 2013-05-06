package com.abstractthis.asciiart.command;

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

import com.abstractthis.asciiart.widget.AsciiArtWidget;
import com.abstractthis.consoul.ConsoleOutPipe;
import com.abstractthis.consoul.commands.ConsoleCommand;
import com.abstractthis.consoul.commands.command.Command;
import com.abstractthis.consoul.commands.exception.CommandPerformException;

public class ShowCommand implements Command {

	@Override
	public String getManual() {
		StringBuilder sb = new StringBuilder(128);
		sb.append("Outputs the contents of the file contained in the [working_dir]/art")
		  .append("\nwith the specified name. It's assumed the file associated with")
		  .append("\nspecified name is contained in the aforementioned directory.")
		  .append("\n\nParameters:\n")
		  .append("Name of the file containing the art found in [working_dir]/art dir");
		return sb.toString();
	}

	@Override
	public String getUsage() {
		return "show [ascii-art-filename]";
	}

	@Override
	public void perform(ConsoleCommand command) throws CommandPerformException {
		ConsoleOutPipe out = command.getCommandOutputPipe();
		String[] args = command.getCommandArguments();
		out.displayWidget(new AsciiArtWidget(args[0]));
		out.sendAndFlush("");
	}

	@Override
	public boolean verifyArguments(String[] cmdArgs) {
		return cmdArgs.length == 1;
	}

}
