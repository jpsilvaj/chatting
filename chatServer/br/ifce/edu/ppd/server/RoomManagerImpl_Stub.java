// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package br.ifce.edu.ppd.server;

public final class RoomManagerImpl_Stub
    extends java.rmi.server.RemoteStub
    implements br.ifce.edu.ppd.commons.IRoomManager, java.rmi.Remote
{
    private static final java.rmi.server.Operation[] operations = {
	new java.rmi.server.Operation("boolean addClientToRoom(java.lang.String, br.ifce.edu.ppd.commons.Client)"),
	new java.rmi.server.Operation("boolean createRoom(java.lang.String, br.ifce.edu.ppd.commons.Client)"),
	new java.rmi.server.Operation("boolean deleteRoom(java.lang.String, br.ifce.edu.ppd.commons.Client)"),
	new java.rmi.server.Operation("java.util.Set getClientsConnectedByRoomName(java.lang.String)"),
	new java.rmi.server.Operation("br.ifce.edu.ppd.commons.IRoom getRoomByClient(br.ifce.edu.ppd.commons.Client)"),
	new java.rmi.server.Operation("java.util.List getRoomList()"),
	new java.rmi.server.Operation("boolean removeClientFromRoom(java.lang.String, br.ifce.edu.ppd.commons.Client)"),
	new java.rmi.server.Operation("boolean sendMessageToRoom(java.lang.String, java.lang.String, br.ifce.edu.ppd.commons.Client)")
    };
    
    private static final long interfaceHash = 8587063033422795022L;
    
    private static final long serialVersionUID = 2;
    
    private static boolean useNewInvoke;
    private static java.lang.reflect.Method $method_addClientToRoom_0;
    private static java.lang.reflect.Method $method_createRoom_1;
    private static java.lang.reflect.Method $method_deleteRoom_2;
    private static java.lang.reflect.Method $method_getClientsConnectedByRoomName_3;
    private static java.lang.reflect.Method $method_getRoomByClient_4;
    private static java.lang.reflect.Method $method_getRoomList_5;
    private static java.lang.reflect.Method $method_removeClientFromRoom_6;
    private static java.lang.reflect.Method $method_sendMessageToRoom_7;
    
    static {
	try {
	    java.rmi.server.RemoteRef.class.getMethod("invoke",
		new java.lang.Class[] {
		    java.rmi.Remote.class,
		    java.lang.reflect.Method.class,
		    java.lang.Object[].class,
		    long.class
		});
	    useNewInvoke = true;
	    $method_addClientToRoom_0 = br.ifce.edu.ppd.commons.IRoomManager.class.getMethod("addClientToRoom", new java.lang.Class[] {java.lang.String.class, br.ifce.edu.ppd.commons.Client.class});
	    $method_createRoom_1 = br.ifce.edu.ppd.commons.IRoomManager.class.getMethod("createRoom", new java.lang.Class[] {java.lang.String.class, br.ifce.edu.ppd.commons.Client.class});
	    $method_deleteRoom_2 = br.ifce.edu.ppd.commons.IRoomManager.class.getMethod("deleteRoom", new java.lang.Class[] {java.lang.String.class, br.ifce.edu.ppd.commons.Client.class});
	    $method_getClientsConnectedByRoomName_3 = br.ifce.edu.ppd.commons.IRoomManager.class.getMethod("getClientsConnectedByRoomName", new java.lang.Class[] {java.lang.String.class});
	    $method_getRoomByClient_4 = br.ifce.edu.ppd.commons.IRoomManager.class.getMethod("getRoomByClient", new java.lang.Class[] {br.ifce.edu.ppd.commons.Client.class});
	    $method_getRoomList_5 = br.ifce.edu.ppd.commons.IRoomManager.class.getMethod("getRoomList", new java.lang.Class[] {});
	    $method_removeClientFromRoom_6 = br.ifce.edu.ppd.commons.IRoomManager.class.getMethod("removeClientFromRoom", new java.lang.Class[] {java.lang.String.class, br.ifce.edu.ppd.commons.Client.class});
	    $method_sendMessageToRoom_7 = br.ifce.edu.ppd.commons.IRoomManager.class.getMethod("sendMessageToRoom", new java.lang.Class[] {java.lang.String.class, java.lang.String.class, br.ifce.edu.ppd.commons.Client.class});
	} catch (java.lang.NoSuchMethodException e) {
	    useNewInvoke = false;
	}
    }
    
    // constructors
    public RoomManagerImpl_Stub() {
	super();
    }
    public RoomManagerImpl_Stub(java.rmi.server.RemoteRef ref) {
	super(ref);
    }
    
    // methods from remote interfaces
    
    // implementation of addClientToRoom(String, Client)
    public boolean addClientToRoom(java.lang.String $param_String_1, br.ifce.edu.ppd.commons.Client $param_Client_2)
	throws java.rmi.RemoteException
    {
	try {
	    if (useNewInvoke) {
		Object $result = ref.invoke(this, $method_addClientToRoom_0, new java.lang.Object[] {$param_String_1, $param_Client_2}, 7774541161767795715L);
		return ((java.lang.Boolean) $result).booleanValue();
	    } else {
		java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 0, interfaceHash);
		try {
		    java.io.ObjectOutput out = call.getOutputStream();
		    out.writeObject($param_String_1);
		    out.writeObject($param_Client_2);
		} catch (java.io.IOException e) {
		    throw new java.rmi.MarshalException("error marshalling arguments", e);
		}
		ref.invoke(call);
		boolean $result;
		try {
		    java.io.ObjectInput in = call.getInputStream();
		    $result = in.readBoolean();
		} catch (java.io.IOException e) {
		    throw new java.rmi.UnmarshalException("error unmarshalling return", e);
		} finally {
		    ref.done(call);
		}
		return $result;
	    }
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of createRoom(String, Client)
    public boolean createRoom(java.lang.String $param_String_1, br.ifce.edu.ppd.commons.Client $param_Client_2)
	throws java.rmi.RemoteException
    {
	try {
	    if (useNewInvoke) {
		Object $result = ref.invoke(this, $method_createRoom_1, new java.lang.Object[] {$param_String_1, $param_Client_2}, -6470332922935429191L);
		return ((java.lang.Boolean) $result).booleanValue();
	    } else {
		java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 1, interfaceHash);
		try {
		    java.io.ObjectOutput out = call.getOutputStream();
		    out.writeObject($param_String_1);
		    out.writeObject($param_Client_2);
		} catch (java.io.IOException e) {
		    throw new java.rmi.MarshalException("error marshalling arguments", e);
		}
		ref.invoke(call);
		boolean $result;
		try {
		    java.io.ObjectInput in = call.getInputStream();
		    $result = in.readBoolean();
		} catch (java.io.IOException e) {
		    throw new java.rmi.UnmarshalException("error unmarshalling return", e);
		} finally {
		    ref.done(call);
		}
		return $result;
	    }
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of deleteRoom(String, Client)
    public boolean deleteRoom(java.lang.String $param_String_1, br.ifce.edu.ppd.commons.Client $param_Client_2)
	throws java.rmi.RemoteException
    {
	try {
	    if (useNewInvoke) {
		Object $result = ref.invoke(this, $method_deleteRoom_2, new java.lang.Object[] {$param_String_1, $param_Client_2}, 7993343870929121903L);
		return ((java.lang.Boolean) $result).booleanValue();
	    } else {
		java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 2, interfaceHash);
		try {
		    java.io.ObjectOutput out = call.getOutputStream();
		    out.writeObject($param_String_1);
		    out.writeObject($param_Client_2);
		} catch (java.io.IOException e) {
		    throw new java.rmi.MarshalException("error marshalling arguments", e);
		}
		ref.invoke(call);
		boolean $result;
		try {
		    java.io.ObjectInput in = call.getInputStream();
		    $result = in.readBoolean();
		} catch (java.io.IOException e) {
		    throw new java.rmi.UnmarshalException("error unmarshalling return", e);
		} finally {
		    ref.done(call);
		}
		return $result;
	    }
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of getClientsConnectedByRoomName(String)
    public java.util.Set getClientsConnectedByRoomName(java.lang.String $param_String_1)
	throws java.rmi.RemoteException
    {
	try {
	    if (useNewInvoke) {
		Object $result = ref.invoke(this, $method_getClientsConnectedByRoomName_3, new java.lang.Object[] {$param_String_1}, 5811824462123508864L);
		return ((java.util.Set) $result);
	    } else {
		java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 3, interfaceHash);
		try {
		    java.io.ObjectOutput out = call.getOutputStream();
		    out.writeObject($param_String_1);
		} catch (java.io.IOException e) {
		    throw new java.rmi.MarshalException("error marshalling arguments", e);
		}
		ref.invoke(call);
		java.util.Set $result;
		try {
		    java.io.ObjectInput in = call.getInputStream();
		    $result = (java.util.Set) in.readObject();
		} catch (java.io.IOException e) {
		    throw new java.rmi.UnmarshalException("error unmarshalling return", e);
		} catch (java.lang.ClassNotFoundException e) {
		    throw new java.rmi.UnmarshalException("error unmarshalling return", e);
		} finally {
		    ref.done(call);
		}
		return $result;
	    }
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of getRoomByClient(Client)
    public br.ifce.edu.ppd.commons.IRoom getRoomByClient(br.ifce.edu.ppd.commons.Client $param_Client_1)
	throws java.rmi.RemoteException
    {
	try {
	    if (useNewInvoke) {
		Object $result = ref.invoke(this, $method_getRoomByClient_4, new java.lang.Object[] {$param_Client_1}, 3636223368851864333L);
		return ((br.ifce.edu.ppd.commons.IRoom) $result);
	    } else {
		java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 4, interfaceHash);
		try {
		    java.io.ObjectOutput out = call.getOutputStream();
		    out.writeObject($param_Client_1);
		} catch (java.io.IOException e) {
		    throw new java.rmi.MarshalException("error marshalling arguments", e);
		}
		ref.invoke(call);
		br.ifce.edu.ppd.commons.IRoom $result;
		try {
		    java.io.ObjectInput in = call.getInputStream();
		    $result = (br.ifce.edu.ppd.commons.IRoom) in.readObject();
		} catch (java.io.IOException e) {
		    throw new java.rmi.UnmarshalException("error unmarshalling return", e);
		} catch (java.lang.ClassNotFoundException e) {
		    throw new java.rmi.UnmarshalException("error unmarshalling return", e);
		} finally {
		    ref.done(call);
		}
		return $result;
	    }
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of getRoomList()
    public java.util.List getRoomList()
	throws java.rmi.RemoteException
    {
	try {
	    if (useNewInvoke) {
		Object $result = ref.invoke(this, $method_getRoomList_5, null, 7776347206400738461L);
		return ((java.util.List) $result);
	    } else {
		java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 5, interfaceHash);
		ref.invoke(call);
		java.util.List $result;
		try {
		    java.io.ObjectInput in = call.getInputStream();
		    $result = (java.util.List) in.readObject();
		} catch (java.io.IOException e) {
		    throw new java.rmi.UnmarshalException("error unmarshalling return", e);
		} catch (java.lang.ClassNotFoundException e) {
		    throw new java.rmi.UnmarshalException("error unmarshalling return", e);
		} finally {
		    ref.done(call);
		}
		return $result;
	    }
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of removeClientFromRoom(String, Client)
    public boolean removeClientFromRoom(java.lang.String $param_String_1, br.ifce.edu.ppd.commons.Client $param_Client_2)
	throws java.rmi.RemoteException
    {
	try {
	    if (useNewInvoke) {
		Object $result = ref.invoke(this, $method_removeClientFromRoom_6, new java.lang.Object[] {$param_String_1, $param_Client_2}, 123582668454815300L);
		return ((java.lang.Boolean) $result).booleanValue();
	    } else {
		java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 6, interfaceHash);
		try {
		    java.io.ObjectOutput out = call.getOutputStream();
		    out.writeObject($param_String_1);
		    out.writeObject($param_Client_2);
		} catch (java.io.IOException e) {
		    throw new java.rmi.MarshalException("error marshalling arguments", e);
		}
		ref.invoke(call);
		boolean $result;
		try {
		    java.io.ObjectInput in = call.getInputStream();
		    $result = in.readBoolean();
		} catch (java.io.IOException e) {
		    throw new java.rmi.UnmarshalException("error unmarshalling return", e);
		} finally {
		    ref.done(call);
		}
		return $result;
	    }
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of sendMessageToRoom(String, String, Client)
    public boolean sendMessageToRoom(java.lang.String $param_String_1, java.lang.String $param_String_2, br.ifce.edu.ppd.commons.Client $param_Client_3)
	throws java.rmi.RemoteException
    {
	try {
	    if (useNewInvoke) {
		Object $result = ref.invoke(this, $method_sendMessageToRoom_7, new java.lang.Object[] {$param_String_1, $param_String_2, $param_Client_3}, 9063318395057068277L);
		return ((java.lang.Boolean) $result).booleanValue();
	    } else {
		java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 7, interfaceHash);
		try {
		    java.io.ObjectOutput out = call.getOutputStream();
		    out.writeObject($param_String_1);
		    out.writeObject($param_String_2);
		    out.writeObject($param_Client_3);
		} catch (java.io.IOException e) {
		    throw new java.rmi.MarshalException("error marshalling arguments", e);
		}
		ref.invoke(call);
		boolean $result;
		try {
		    java.io.ObjectInput in = call.getInputStream();
		    $result = in.readBoolean();
		} catch (java.io.IOException e) {
		    throw new java.rmi.UnmarshalException("error unmarshalling return", e);
		} finally {
		    ref.done(call);
		}
		return $result;
	    }
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
}