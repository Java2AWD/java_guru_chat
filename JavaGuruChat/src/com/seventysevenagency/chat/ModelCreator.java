package com.seventysevenagency.chat;

import javax.servlet.http.HttpServletRequest;

public abstract class ModelCreator {
	public abstract IModel createModel(HttpServletRequest request);
}
