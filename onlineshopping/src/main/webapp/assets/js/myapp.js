$(function() {
	// solving the active menu problem
	switch (menu) {
	case 'About':
		$('#about').addClass('active');
		break;
	case 'ContactUs':
		$('#contact').addClass('active');
		break;
	default:
		$('#home').addClass('active');
		break;

	}
});