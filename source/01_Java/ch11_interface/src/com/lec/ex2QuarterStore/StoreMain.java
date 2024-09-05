package com.lec.ex2QuarterStore;

public class StoreMain {
	public static void main(String[] args) {
		HeadQuarterStore[] stores = {
			//new HeadQuarterStore("= =본사= ="),	
			new Store1("= = 주택가 1호점  = ="),	
			new Store2("= = 대학가 2호점 = ="),	
			new Store3("= = 증권가 3호점 = ="),				
		};
		
		for(HeadQuarterStore store : stores) {
			System.out.println(store);
			store.kimchi();
			store.bude();
			store.bibim();
			store.sunde();
			store.gongi();
			System.out.println("--------------------");
		}
		
//		for (int idx = 0; idx<stores.length; idx++) {
//			System.out.println(stores[idx].toString());
//			stores[idx].kimchi();
//			stores[idx].bude();
//			stores[idx].bibim();
//			stores[idx].sunde();
//			stores[idx].gongi();
//			System.out.println("--------------------");
//		}
	}
}
