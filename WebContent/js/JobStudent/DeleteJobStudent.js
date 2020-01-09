function DeleteJobStudent(thisStudentInfo) {

	$
			.confirm({
				title : '警告！删除学生',
				content : '此操作将删除所选的学生账号，并且将学生对应的数据一并删除',
				type : 'red',
				autoClose : '取消|5000',// 自动关闭
				buttons : {
					删除 : {
						btnClass : 'btn-red',
						action : function() {

							var xhr = false;
							xhr = new XMLHttpRequest();
							xhr.onreadystatechange = function() {
								var message;
								if (xhr.readyState == 4) {
									if (xhr.status == 200) {
										if (xhr.responseText == "success") {
											toastr.succes("删除成功");
											GetAllJobStudentsByPageAndSearch(jobStudentList.pageIndex);
										}
									} else {
										alert(xhr.status);
									}
								}
							}

							var formData = new FormData();
							var this_i_id = thisStudentInfo.id;
							formData.append("stuinfoStuBaseinfo.stu_id",
									this_i_id);
							xhr.open("POST",
									"/stuinfo/jobStudent/DeleteJobStudent");
							xhr.send(formData);
						}
					},
					取消 : function() {
					}
				}
			});

}