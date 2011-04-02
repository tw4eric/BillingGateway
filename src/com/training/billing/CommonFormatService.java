package com.training.billing;

import org.mockito.Mockito;

public interface CommonFormatService {

	public boolean doesFileExist(String myFilePath);

	public String next();

	public boolean OpenFile(String myFilePath);

}
