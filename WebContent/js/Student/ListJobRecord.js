//将获取到工作记录在页面上显示
function ListJobRecord() {

	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				var jobRecordList = JSON.parse(xhr.responseText);
				var cd_timeline = document.getElementById("cd-timeline");
				for (num = 0; num < jobRecordList.length; num++) {
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
					table_1.id = "job_rocord"
					table_1.innerHTML = '<tr>'
							+ '<td class="first_td title_td">单位名称：</td>'
							+ '<td>'
							+ jobRecordList[num].stu_job_comname
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td class="first_td title_td">单位地点：</td>'
							+ '<td>'
							+ jobRecordList[num].stu_job_comadress
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td class="first_td title_td">组织机构代码：</td>'
							+ '<td>'
							+ jobRecordList[num].stu_job_constitute_code
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td class="first_td title_td">单位行业：</td>'
							+ '<td>'
							+ jobRecordList[num].stu_job_industry
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td class="first_td title_td">单位联系人姓名：</td>'
							+ '<td>'
							+ jobRecordList[num].stu_job_contactname
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td class="first_td title_td">单位联系人电话：</td>'
							+ '<td>'
							+ jobRecordList[num].stu_job_contactnum
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td class="first_td title_td">开始工作时间：</td>'
							+ '<td>'
							+ jobRecordList[num].stu_job_indate
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td class="first_td title_td">离职时间：</td>'
							+ '<td>'
							+ jobRecordList[num].stu_job_outdate
							+ '</td>'
							+ '</tr>'
							+ '<tr>'
							+ '<td class="first_td title_td">在职状态：</td>'
							+ '<td>'
							+ jobRecordList[num].stu_job_status
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
	xhr.open("POST", "/stuinfo/loginAndLogout/GetJobRecodeById");
	xhr.send(null);

}