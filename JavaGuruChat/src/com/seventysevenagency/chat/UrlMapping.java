package com.seventysevenagency.chat;

public class UrlMapping {

	private ModelCreator modelCreator;
	private Controller controller;
	private String jsp;
	private String url;

	public ModelCreator getModelCreator() {
		return modelCreator;
	}

	public void setModelCreator(ModelCreator modelCreator) {
		this.modelCreator = modelCreator;
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public String getJsp() {
		return jsp;
	}

	public void setJsp(String jsp) {
		this.jsp = jsp;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
