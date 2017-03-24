package com.alithya.expedia.errorstate;

import com.alithya.expedia.exception.InvalidPrintCommandException;

public class InvalidPrintCommandErrorState implements ErrorState {

	@Override
	public void throwError() throws Exception {
		throw new InvalidPrintCommandException();
	}
}
