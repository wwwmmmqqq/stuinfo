function AddJobRecode() {
	var job_recode_table = document.getElementById("job_recode_table");
	job_recode_table.innerHTML = "";
	job_recode_table.innerHTML = ' <table class="table">'
			+ '<tr>'
			+ '<td>单位名称：</td>'
			+ '<td><input type="text" class="form-control " id="add_stu_job_comname"/></td>'

			+ '<td>单位地点：</td>'
			+ '<td><input type="text" class="form-control " id="add_stu_job_comadress" /></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>组织机构代码：</td>'
			+ '<td><input type="text" class="form-control " id="add_stu_job_constitute_code"/></td>'
			+ '<td>单位行业：</td>'
			+ '<td><input type="text" class="form-control " id="add_stu_job_industry"/></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>单位联系人姓名：</td>'
			+ '<td><input type="text" class="form-control " id="add_stu_job_contactname"/></td>'
			+ '<td>单位联系人电话：</td>'
			+ '<td><input type="text" class="form-control " id="add_stu_job_contactnum"/></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>开始工作时间：</td>'
			+ '<td><input type="text" class="form-control " id="add_stu_job_indate"/></td>'
			+ '<td>离职时间：</td>'
			+ '<td><input type="text" class="form-control " id="add_stu_job_outdate"/></td>'
			+ '</tr>' + ' </table>'
}

function ConfirmAddJobRecode() {
	var add_stu_job_comname = document.getElementById("add_stu_job_comname");
	var add_stu_job_comadress = document
			.getElementById("add_stu_job_comadress");
	var add_stu_job_constitute_code = document
			.getElementById("add_stu_job_constitute_code");
	var add_stu_job_industry = document.getElementById("add_stu_job_industry");
	var add_stu_job_contactname = document
			.getElementById("add_stu_job_contactname");
	var add_stu_job_contactnum = document
			.getElementById("add_stu_job_contactnum");
	var add_stu_job_indate = document.getElementById("add_stu_job_indate");
	var add_stu_job_outdate = document.getElementById("add_stu_job_outdate");

	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				if (xhr.responseText == "success") {
					alert("添加成功");
					jc.close();
				}
			} else {
				alert(xhr.status);
			}
		}
	}
	var formData = new FormData();
	formData.append("stuinfoStuOnjob.stu_job_comname",
			add_stu_job_comname.value);
	formData.append("stuinfoStuOnjob.stu_job_comadress",
			add_stu_job_comadress.value);
	formData.append("stuinfoStuOnjob.stu_job_constitute_code",
			add_stu_job_constitute_code.value);
	formData.append("stuinfoStuOnjob.stu_job_industry",
			add_stu_job_industry.value);
	formData.append("stuinfoStuOnjob.stu_job_contactname",
			add_stu_job_contactname.value);
	formData.append("stuinfoStuOnjob.stu_job_contactnum",
			add_stu_job_contactnum.value);
	formData.append("stuinfoStuOnjob.stu_job_indate", add_stu_job_indate.value);
	formData.append("stuinfoStuOnjob.stu_job_outdate",
			add_stu_job_outdate.value);
	formData.append("stuinfoNotice.notice_content", "添加了工作记录");
	xhr.open("POST", "/stuinfo/loginAndLogout/StudentAddJobInfo");
	xhr.send(formData);

	return false;
}
function WarnAddJobRecode() {

	var jc = $.confirm({

		title : '警告！添加工作记录',
		content : '提交后信息不可再更改，请确认是否提交！',
		type : 'red',
		buttons : {
			'确定' : {
				btnClass : 'btn-blue',
				action : function() {
					ConfirmAddJobRecode();
				}
			},
			'取消' : {}
		},
	})
}
