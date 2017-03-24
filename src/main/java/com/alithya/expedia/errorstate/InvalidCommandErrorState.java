package com.alithya.expedia.errorstate;

import com.alithya.expedia.exception.InvalidCommandException;

public class InvalidCommandErrorState implements ErrorState {

	@Override
	public void throwError() throws Exception {
		throw new InvalidCommandException();
	}

}
