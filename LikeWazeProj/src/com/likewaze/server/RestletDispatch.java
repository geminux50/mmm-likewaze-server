package com.likewaze.server;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;



/**
 * Here we dispatch all the requests to the corresponding controller 
 * 
 * */
public class RestletDispatch extends Application
{
	@Override
	public synchronized Restlet createInboundRoot()
	{

		final Router router = new Router(getContext());

		 router.attach("/user", UserController.class);
		 router.attach("/device", DeviceController.class);
		 // TODO ADD more filtering in RestletDispatch class 
		return router;
	}

}
