package com.abstractthis.asciiart.core;

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
