package com.abstractthis.asciiart.core;

import com.abstractthis.consoul.commands.AbstractCommandExecutor;
import com.abstractthis.consoul.commands.ConsoleCommand;

public class AsciiArtExecutor extends AbstractCommandExecutor {

	@Override
	protected void handleCommandInitException(ConsoleCommand cmd, Throwable t) {
		String msg = String.format("Problems initializing command '%s'", cmd.getCommandName());
		System.err.println(msg);
	}

	@Override
	protected void handleCommandNotFoundException(ConsoleCommand cmd, Throwable t) {
		String msg = String.format("Command 404 for '%s'", cmd.getCommandName());
		System.err.println(msg);
	}

	@Override
	protected void handleCommandPerformException(ConsoleCommand cmd, Throwable t) {
		String msg = String.format("Performance problem for command '%s'", cmd.getCommandName());
		System.err.println(msg);
	}

	@Override
	protected void handleCommandPermissionException(ConsoleCommand cmd, Throwable t) {
		String msg = String.format("Permission problem for command '%s'", cmd.getCommandName());
		System.err.println(msg);
	}

}
