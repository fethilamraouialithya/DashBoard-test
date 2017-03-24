package com.alithya.expedia.errorstate;

import com.alithya.expedia.exception.NoGameInProgressException;

public class NoGameInProgressErrorState implements ErrorState {

	@Override
	public void throwError() throws Exception {
		throw new NoGameInProgressException();
	}

}
