package com.seventysevenagency.chat.models;

import javax.servlet.http.HttpServletRequest;


public abstract class ModelCreator {
	public abstract IModel createModel(HttpServletRequest request);
}
