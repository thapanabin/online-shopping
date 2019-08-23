$(function() {
	// solving the active menu problem
	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;

	default:
		if (menu == 'Home')
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;

	}

	// code for jquery dataTable
	var $table = $('#productListTable');

	// execute this code only when we have this table

	if ($table.length) {

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}
		$table
				.DataTable({
					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records,', 'ALL' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'code',
								mRender : function(data, type, row) {
									return '<img src = "' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class = "dataTableImg"/>';
								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#36; ' + data // for rupee symbol
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red">Out of Stock</span>'
									}
									return data;
								}

							},
							{
								data : 'id',
								bSortable : false,// for disabling the sort
													// function in this
								// column
								mRender : function(data, type, row) {
									var str = '';// &#160 for adding the
													// extra space
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class = "btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a>&#160;'

									if (row.quantity < 1) {
										str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>'
									} else {
										str += '<a href="'
												+ window.contextRoot
												+ '/cart/add/'
												+ data
												+ '/product" class = "btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>'

									}

									return str;
								}
							} ]

				});
	}

	// dismissing the alert after 3 seconds
	var $alert = $('.alert');
	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000);
	}

	//------------------------------------
	
	

	
	//------------------------------------------
	
	//data table for admin
	
	var $adminProductsTable = $('#adminProductsTable');

	// execute this code only when we have this table

	if ($adminProductsTable.length) {

		var jsonUrl = window.contextRoot+'/json/data/admin/all/products';
		
		$adminProductsTable.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ],
							[ '10 Records', '30 Records', '50 Records,', 'ALL' ] ],
					pageLength : 30,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data: 'id'
							},
							{
								data : 'code',
								mRender : function(data, type, row) {
									return '<img src = "' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class = "adminDataTableImg"/>';
								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							
							{
								data : 'quantity',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red">Out of Stock</span>'
									}
									return data;
								}

							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#36; ' + data // for dollor symbol
								}
							},
							{
								data : 'active',
								bSortable: false,
								mRender: function(data, type, row) {
									var str = '';
									str+= '<label class="switch">';									
								if(data){
									str+= '<input type="checkbox" checked="checked" value="'+row.id+'"/>"' ;
								}else{
									str+= '<input type="checkbox"  value="'+row.id+'"/>"' ;
								}
								
							str+= '<div class="slider"></div></label>';
							
							return str;
								}
								
								

							},
							{
								data:'id',
								bSortable: false,
								mRender: function(data,type,row){
									var str = '';
									
								str+='<a href="'+window.contextRoot+'/manage/'+data+'/product" class="btn btn-warning">';
								str+='<span class="glyphicon glyphicon-pencil"></span></a>'
								
									return str;
								}
							}
							],
							
						initComplete: function(){
							
							var api = this.api();
							api.$('.switch input[type="checkbox"]')
							.on('change',function() {

								var checkbox = $(this);
								var checked = checkbox.prop('checked');
								var dMsg = (checked)? 'You want to activate the product?':
										 'You want to deactivate the product?';
								var value = checkbox.prop('value');
								bootbox.confirm({
											size : 'medium',
											title : 'Product Activation & Deactivation',
											message : dMsg,
											callback : function(confirmed) {
												if (confirmed) {
													console.log(value);
													bootbox.alert({
																size : 'medium',
																title : 'Information',
																message : 'you are going to perform operation on product'
																		+ value,
															});
												} else {
													checkbox.prop('checked', !checked);

												}
											}
										});

							});
						}

				});
	}

	
	//-----------------------------------------
	


});
