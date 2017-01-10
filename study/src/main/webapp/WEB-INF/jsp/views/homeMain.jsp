<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<body>
	<div class="container">
		<section role="main" id="content" class="content left">
			<div class="xe-widget-wrapper">
				<div style="*zoom: 1; padding: 0px 10px 0px 0px !important;">
					<div class="c_widget ct_box"
						style="padding: 20px; border-bottom: 1px dotted #CCC; background-color: #FFF;">
						<h2 class="w_headline">
							<a href="/study">IT<span class="page_count num"></span></a>
						</h2>
						<div class="w_list w_normal"
							style="*zoom: 1; padding: 5px 5px 5px 5px !important;">
							<table class="table" style="font-size: 14">
								<tbody>
									<tr>
										<th scope="row">1</th>
										<td style="cursor: pointer; width: 290px"
											onclick="javascript:clickTitleEvent(this)">IT Title 1</td>
										<td style="cursor: pointer"
											onclick="javascript:clickUserEvent(this)">user Name 11</td>
										<td>2016.12.20</td>
									</tr>
									<tr>
										<th scope="row">2</th>
										<td style="cursor: pointer; width: 290px"
											onclick="javascript:clickTitleEvent(this)">IT Title 2</td>
										<td style="cursor: pointer"
											onclick="javascript:clickUserEvent(this)">user Name 12</td>
										<td>2016.12.20</td>
									</tr>
									<tr>
										<th scope="row">3</th>
										<td style="cursor: pointer; width: 290px"
											onclick="javascript:clickTitleEvent(this)">IT Title 2</td>
										<td style="cursor: pointer"
											onclick="javascript:clickUserEvent(this)">user Name 13</td>
										<td>2016.12.19</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="xe-widget-wrapper">
				<div style="*zoom: 1; padding: 0px 10px 0px 0px !important;">
					<div class="c_widget ct_box"
						style="padding: 20px; border-top: 1px dotted #CCC; border-bottom: 1px dotted #CCC; background-color: #FFF;">
						<h2 class="w_headline">
							<a href="/study">English</a>
						</h2>
						<div class="w_list w_normal"
							style="*zoom: 1; padding: 5px 5px 5px 5px !important;">
							<table class="table" style="font-size: 14">
								<tbody>
									<tr>
										<th scope="row">1</th>
										<td style="cursor: pointer; width: 290px"
											onclick="javascript:clickTitleEvent(this)">English Title
											1</td>
										<td style="cursor: pointer"
											onclick="javascript:clickUserEvent(this)">user Name 21</td>
										<td>2016.12.20</td>
									</tr>
									<tr>
										<th scope="row">2</th>
										<td style="cursor: pointer; width: 290px"
											onclick="javascript:clickTitleEvent(this)">English Title
											2</td>
										<td style="cursor: pointer"
											onclick="javascript:clickUserEvent(this)">user Name 22</td>
										<td>2016.12.20</td>
									</tr>
									<tr>
										<th scope="row">3</th>
										<td style="cursor: pointer; width: 290px"
											onclick="javascript:clickTitleEvent(this)">English
											Title 2</td>
										<td style="cursor: pointer"
											onclick="javascript:clickUserEvent(this)">user Name 23</td>
										<td>2016.12.19</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="xe-widget-wrapper">
				<div style="*zoom: 1; padding: 0px 10px 0px 0px !important;">
					<div class="c_widget ct_box"
						style="padding: 20px; border-top: 1px dotted #CCC; border-bottom: 1px dotted #CCC; background-color: #FFF;">
						<h2 class="w_headline">
							<a href="/study">Chinese</a>
						</h2>
						<div class="w_list w_normal"
							style="*zoom: 1; padding: 5px 5px 5px 5px !important;">
							<table class="table" style="font-size: 14">
								<tbody>
									<tr>
										<th scope="row">1</th>
										<td style="cursor: pointer; width: 290px"
											onclick="javascript:clickTitleEvent(this)">Chinese Title
											1</td>
										<td style="cursor: pointer"
											onclick="javascript:clickUserEvent(this)">user Name 31</td>
										<td>2016.12.20</td>
									</tr>
									<tr>
										<th scope="row">2</th>
										<td style="cursor: pointer; width: 290px"
											onclick="javascript:clickTitleEvent(this)">Chinese Title
											2</td>
										<td style="cursor: pointer"
											onclick="javascript:clickUserEvent(this)">user Name 32</td>
										<td>2016.12.20</td>
									</tr>
									<tr>
										<th scope="row">3</th>
										<td style="cursor: pointer; width: 290px"
											onclick="javascript:clickTitleEvent(this)">Chinese Title
											2</td>
										<td style="cursor: pointer"
											onclick="javascript:clickUserEvent(this)">user Name 33</td>
										<td>2016.12.19</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
	<div class="footer_wrap">
		<footer class="footer">
			<div class="bottom_menu">
				<ul>
					<li><a href="/notice/main">Notice</a><span>|</span></li>
				</ul>
			</div>
		</footer>
	</div>
</body>

<script type="text/javascript">
	function clickTitleEvent(title) {
		window.open('/study_info', '_self');

	}

	function clickUserEvent(user) {
		$('[data-submenu]').submenupicker();
	}
</script>