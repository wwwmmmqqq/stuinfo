// 获取到所有的未读消息
var NoticeList = null;
var noticeReadList = null;
function ListAllNoticesByPageAndSearch(pageIndex) {
	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				NoticeList = JSON.parse(xhr.responseText);
				/*
				 * 
				 * 清空原表数据
				 * 
				 */
				var new_tr_list = document.getElementsByClassName("new_tr");
				var long = new_tr_list.length;
				for (var num = 0; num < long; num++) {
					new_tr_list[0].parentNode.removeChild(new_tr_list[0]);
				}
				var notice_table = document.getElementById("notice_table");
				var new_tr = null;
				var new_td = null;
				for (num = 0; num < NoticeList.stuinfoNotice.length; num++) {
					new_tr = document.createElement("tr");
					notice_table.firstElementChild.appendChild(new_tr);
					new_tr.className = "new_tr";
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = num + 1;

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = NoticeList.stuinfoNotice[num].notice_stu_grade
							+ NoticeList.stuinfoNotice[num].notice_stu_major
							+ NoticeList.stuinfoNotice[num].notice_stu_class
							+ NoticeList.stuinfoNotice[num].notice_stu_account
							+ NoticeList.stuinfoNotice[num].notice_stu_name
							+ NoticeList.stuinfoNotice[num].notice_content;

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = NoticeList.stuinfoNotice[num].notice_infocreate;

					var pager = document.getElementById("pager");
					pager.className = "pager";
					pager.innerHTML = '<li>'
							+ '<a href="#" onclick="flipAllNotices(1)">上一页</a></li>'
							+ '<li><a href="#" onclick="flipAllNotices(2)">下一页</a></li>'
				}
			} else {
				alert(xhr.status);
			}
		}
	}

	xhr.open("POST", "/stuinfo/noticeManage/listNoticeByPageAndSearch");
	var formData = new FormData();
	if (pageIndex == null || pageIndex.preventDefault) {
		pageIndex = 1;
	}
	formData.append("noticeVO.pageIndex", pageIndex);
	xhr.send(formData);
}
// 未读消息的翻页
function flipAllNotices(flipPage) {
	switch (flipPage) {
	case 1: {
		if (NoticeList.pageIndex - 1 == 0) {
			toastr.warning("已经是第一页了");
		} else {
			ListAllNoticesByPageAndSearch(NoticeList.pageIndex - 1);
		}
		break;
	}
	case 2: {
		if (NoticeList.pageIndex == NoticeList.totalPages) {
			toastr.warning("已经是最后一页了");
		} else {
			ListAllNoticesByPageAndSearch(NoticeList.pageIndex + 1);
		}
		break;
	}

	}
}
// 获取所有已读消息
function ListAllReadNoticesByPageAndSearch(pageIndex) {

	var xhr = false;
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		var message;
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				noticeReadList = JSON.parse(xhr.responseText);
				/*
				 * 
				 * 清空原表数据
				 * 
				 */
				var new_tr_list = document.getElementsByClassName("new_tr");
				var long = new_tr_list.length;
				for (var num = 0; num < long; num++) {
					new_tr_list[0].parentNode.removeChild(new_tr_list[0]);
				}
				var notice_table = document.getElementById("notice_table");
				var new_tr = null;
				var new_td = null;
				for (num = 0; num < noticeReadList.stuinfoNotice.length; num++) {
					new_tr = document.createElement("tr");
					notice_table.firstElementChild.appendChild(new_tr);
					new_tr.className = "new_tr";
					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = num + 1;

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = noticeReadList.stuinfoNotice[num].notice_stu_grade
							+ noticeReadList.stuinfoNotice[num].notice_stu_major
							+ noticeReadList.stuinfoNotice[num].notice_stu_class
							+ noticeReadList.stuinfoNotice[num].notice_stu_account
							+ noticeReadList.stuinfoNotice[num].notice_stu_name
							+ noticeReadList.stuinfoNotice[num].notice_content;

					new_td = document.createElement("td");
					new_tr.appendChild(new_td);
					new_td.innerHTML = NoticeList.stuinfoNotice[num].notice_infocreate;

					var pager = document.getElementById("pager");
					pager.className = "pager";
					pager.innerHTML = '<li>'
							+ '<a href="#" onclick="flipAllReadNotices(1)">上一页</a></li>'
							+ '<li><a href="#" onclick="flipAllReadNotices(2)">下一页</a></li>'

				}
			} else {
				alert(xhr.status);
			}
		}
	}

	xhr.open("POST", "/stuinfo/noticeManage/listReadNoticeByPageAndSearch");
	var formData = new FormData();
	if (pageIndex == null || pageIndex.preventDefault) {
		pageIndex = 1;
	}
	formData.append("noticeVO.pageIndex", pageIndex);
	xhr.send(formData);

}
// 已读消息的翻页
function flipAllReadNotices(flipPage) {
	switch (flipPage) {
	case 1: {
		if (noticeReadList.pageIndex - 1 == 0) {
			toastr.warning("已经是第一页了");
		} else {
			ListAllReadNoticesByPageAndSearch(noticeReadList.pageIndex - 1);
		}
		break;
	}
	case 2: {
		if (noticeReadList.pageIndex == noticeReadList.totalPages) {
			toastr.warning("已经是最后一页了");
		} else {
			ListAllReadNoticesByPageAndSearch(noticeReadList.pageIndex + 1);
		}
		break;
	}

	}
}
// 点击已读的时候加载已读方法
function ReadedOnclick() {
	ListAllReadNoticesByPageAndSearch(1);
	var ReadNotice = document.getElementById("ReadNotice");
	var UnNotice = document.getElementById("UnNotice");
	ReadNotice.classList.add("active");
	UnNotice.classList.remove("active");
}
// 点击未读是加载未读方法
function NonReadOnclick() {
	ListAllNoticesByPageAndSearch(1);
	var ReadNotice = document.getElementById("ReadNotice");
	var UnNotice = document.getElementById("UnNotice");
	UnNotice.classList.add("active");
	ReadNotice.classList.remove("active");
}
