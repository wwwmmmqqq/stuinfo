var this_stu_id = null;
function detailJobStudent() {
	this_stu_id = window.location.search.substr(27);
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				var jobStudentListById = JSON.parse(xhr.responseText);
				var cd_timeline = document.getElementById("cd-timeline");
				for (num = 0; num < jobStudentListById.length; num++) {
					var div_1 = document.createElement("div");
					cd_timeline.appendChild(div_1);
					div_1.className = "cd-timeline-block";

					var div_2 = document.createElement("div");
					div_1.appendChild(div_2);
					div_2.className = "cd-timeline-img cd-success";
					div_2.innerHTML = num + 1;

					var div_3 = document.createElement("div");
					div_1.appendChild(div_3);
					div_3.className = "cd-timeline-content";

					var table_1 = document.createElement("table");
					div_3.appendChild(table_1);
					table_1.className = "table";
					table_1.innerHTML = '<tr>'
							+ '<td class="first_td">单位名称：</td>' + '<td>'
							+ jobStudentListById[num].stuinfoStuOnJob.stu_job_comname
							+ '</td>'
							+ '<td class="first_td">单位地点：</td>'
							+ '<td>'
							+ jobStudentListById[num].stuinfoStuOnJob.stu_job_comadress
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td class="first_td">组织机构代码：</td>'
							+ '<td>'
							+ jobStudentListById[num].stuinfoStuOnJob.stu_job_constitute_code
							+ '</td>'
							+ '<td class="first_td">单位行业：</td>'
							+ '<td>'
							+ jobStudentListById[num].stuinfoStuOnJob.stu_job_industry
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td class="first_td">单位联系人姓名：</td>'
							+ '<td>'
							+ jobStudentListById[num].stuinfoStuOnJob.stu_job_contactname
							+ '</td>'
							+ '<td class="first_td">单位联系人电话：</td>'
							+ '<td>'
							+ jobStudentListById[num].stuinfoStuOnJob.stu_job_contactnum
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td class="first_td">开始工作时间：</td>'
							+ '<td>'
							+ jobStudentListById[num].stuinfoStuOnJob.stu_job_indate
							+ '</td>'
							+ '<td class="first_td">离职时间：</td>'
							+ '<td>'
							+ jobStudentListById[num].stuinfoStuOnJob.stu_job_outdate
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td class="first_td">在职状态：</td>'
							+ '<td>'
							+ jobStudentListById[num].stuinfoStuOnJob.stu_job_status
							+ '</td>' + '</tr>'
				}
				var lable_td = document.getElementsByTagName("td");
				for (i = 0; i < lable_td.length; i++) {
					if (lable_td[i].innerHTML == "undefined"
							|| lable_td[i].innerHTML == "") {
						lable_td[i].innerHTML = "无"
					}

				}
			} else {
				alert(xhr.status);
			}
		}
	}
	xhr.open("POST", "/stuinfo/jobStudent/getJobStuById");
	var formData = new FormData();
	formData.append("stuinfoStuBaseinfo.stu_id", this_stu_id);
	xhr.send(formData);
}

function detailBaseJobStudent() {

	var stu_account = document.getElementById('stu_account');
	var stu_name = document.getElementById('stu_name');
	var stu_photo = document.getElementById('stu_photo');
	var stu_sex = document.getElementById('stu_sex');
	var stu_adress = document.getElementById('stu_adress');
	var stu_bir = document.getElementById('stu_bir');
	var stu_familytype = document.getElementById('stu_familytype');
	var stu_nation = document.getElementById('stu_nation');
	var stu_policits = document.getElementById('stu_policits');
	var stu_idcard = document.getElementById('stu_idcard');
	var stu_phenumber = document.getElementById('stu_phenumber');
	var stu_fathername = document.getElementById('stu_fathername');
	var stu_fathernum = document.getElementById('stu_fathernum');
	var stu_lev = document.getElementById('stu_lev');
	var stu_change = document.getElementById('stu_change');
	var stu_college = document.getElementById('stu_college');
	var stu_const = document.getElementById('stu_const');
	var stu_major = document.getElementById('stu_major');
	var stu_class_id = document.getElementById('stu_class_id');
	var stu_grade_id = document.getElementById('stu_grade_id');
	var stu_year = document.getElementById('stu_year');

	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {

				var schoolStudentListById = JSON.parse(xhr.responseText);
				var school_student_table = document
						.getElementById("school_student_table");
				var new_tr = null;
				var new_td = null;

				stu_account.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_account;
				stu_name.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_name;
				stu_photo.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_photo;
				stu_sex.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_sex;
				stu_bir.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_bir;
				stu_familytype.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_familytype;
				stu_policits.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_policits;
				stu_nation.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_nation;
				stu_idcard.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_idcard;
				stu_phenumber.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_phenumber;
				stu_fathername.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_fathername;
				stu_lev.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_lev;
				stu_change.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_change;
				stu_college.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_college;
				stu_const.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_const;
				stu_major.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_major;
				stu_class_id.value = schoolStudentListById[0].stuinfoStuClass.stu_class_name;
				stu_grade_id.value = schoolStudentListById[0].stuinfoStuGrade.stu_grade_name;
				stu_year.value = schoolStudentListById[0].stuinfoStuBaseinfo.stu_year;

			}

		}
	}
	xhr.open("POST", "/stuinfo/schoolStudent/getSchoolStuById");
	var formData = new FormData();
	var this_i_id = this_stu_id;
	formData.append("stuinfoStuBaseinfo.stu_id", this_i_id);
	xhr.send(formData);

}