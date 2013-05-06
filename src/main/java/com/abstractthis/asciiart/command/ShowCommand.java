package com.abstractthis.asciiart.command;

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
