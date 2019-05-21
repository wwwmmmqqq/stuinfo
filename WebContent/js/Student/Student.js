//点击基本信息显示和隐藏功能
function BaseInfoToogle() {

	var sh = document.getElementById("base_panel").classList.contains('show');
	if (sh) {
		document.getElementById("base_panel").classList.remove('show');
		document.getElementById("base_panel").classList.add('hide');
	} else {
		document.getElementById("base_panel").classList.remove('hide');
		document.getElementById("base_panel").classList.add('show');
	}

}