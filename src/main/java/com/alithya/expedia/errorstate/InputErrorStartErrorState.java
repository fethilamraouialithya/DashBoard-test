package com.alithya.expedia.errorstate;

import com.alithya.expedia.exception.InvalidStartCommandException;

public class InputErrorStartErrorState implements ErrorState {

	@Override
	public void throwError() throws Exception {
		throw new InvalidStartCommandException();		
	}
}
