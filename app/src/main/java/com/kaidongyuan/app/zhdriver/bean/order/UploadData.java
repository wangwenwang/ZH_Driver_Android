package com.kaidongyuan.app.zhdriver.bean.order;


import java.util.List;

public class UploadData implements java.io.Serializable {
	List<UploadProduct> productList;

	public UploadData(List<UploadProduct> productList) {
		this.productList = productList;
	}

	public List<UploadProduct> getProductList() {
		return productList;
	}

	public void setProductList(List<UploadProduct> productList) {
		this.productList = productList;
	}
}
