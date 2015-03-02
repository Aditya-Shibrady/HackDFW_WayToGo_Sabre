$(document).ready(function(){
	window.setTimeout(function(){$("body").scrollTop(0);}, 50);
	//$(".datepicker").datepicker();
	$("#idea").click(function(){
		$("#idea").addClass("active-background");
		$("#idea").removeClass("inactive-background");
		$("#no-idea").addClass("inactive-background");
		$("#no-idea").removeClass("active-background");
		$("#idea_form").removeClass("zero-height");
		$("#no-idea_form").addClass("zero-height");
		$("#no-idea_form").removeClass("full-height");
		$("#idea_form").addClass("full-height");
		window.setTimeout(function(){
		    $("body").animate({scrollTop: 250}, 500)
		}, 500);
	});
	$("#no-idea").click(function(){
		$("#idea").addClass("inactive-background");
		$("#idea").removeClass("active-background");
		$("#no-idea").addClass("active-background");
		$("#no-idea").removeClass("inactive-background");
		$("#no-idea_form").removeClass("zero-height");
		$("#idea_form").addClass("zero-height");
		$("#idea_form").removeClass("full-height");
		$("#no-idea_form").addClass("full-height");
		$("#theme_input").removeClass("full-height");
		$("#theme_input").addClass("zero-height");
		$("#season_input").removeClass("full-height");
		$("#season_input").addClass("zero-height");
		$("#price_input").removeClass("full-height");
		$("#price_input").addClass("zero-height");
		window.setTimeout(function(){
		    $("body").animate({scrollTop: 250}, 500)
		}, 500);
	});
	$("#no-idea-submit").click(function(){
		$("#results").removeClass("zero-height");
		$("#results").addClass("full-height");
		$.get("http://localhost/myapp/setnoidea/?id1=" + $("#no-idea-origin-input").val(), {}, function(data){
			$.get("http://localhost/myapp/noidea", {}, function(data){
				$("#output").html("");
				var output = "<div class='tab'>";
				console.log(data);
				var parsed = $.parseJSON(data);
				console.log(parsed);
				//$.parseJSON('{"OriginLocation":"JFK","DestinationLocation":"LAX","DepartureDateTime":"2015-03-03T00:00:00","ReturnDateTime":"2015-03-05T00:00:00","Forecast":{"HighestPredictedFare":832,"CurrencyCode":"USD","LowestPredictedFare":511},"Recommendation":"unknown","LowestFare":825.69,"CurrencyCode":"USD","Links":[{"rel":"self","href":"https://api.test.sabre.com/v1/forecast/flights/fares?origin=jfk&destination=LAX&departuredate=2015-03-03&returndate=2015-03-05"},{"rel":"linkTemplate","href":"https://api.test.sabre.com/v1/forecast/flights/fares?origin=&destination=&departuredate=&returndate="},{"rel":"shop","href":"https://api.test.sabre.com/v1/shop/flights?origin=JFK&destination=LAX&departuredate=2015-03-03&returndate=2015-03-05&pointofsalecountry=US"}]}');
				for(var i = 0; i < parsed.Destinations.length; i++){
					var item = parsed.Destinations[i];
					if(item.Destination.Type == "Airport")
						output += "<p class='item'>" + "To: " + item.Destination.CityName + " in " + item.Destination.CountryName + "; Airport Name: " + item.Destination.AirportName + "</p>";
					else if(item.Destination.Type == "City")
						output += "<p class='item'>" + "To: " + item.Destination.MetropolitanAreaName + " in " + item.Destination.CountryName + "</p>";
					else
						output += "<p class='item'>This destination type isn't implemented yet- fire someone.</p>";
					output += "<br/>";
				}
				add(output + "</div>");
				$("body").animate({scrollTop: 600}, 500);
			});
		});
	});
	$("#idea-theme-submit").click(function(){
		$("#results").removeClass("zero-height");
		$("#results").addClass("full-height");
		$.get("http://localhost/myapp/settheme/", {id1: $("#idea-origin-theme-input").val(), id2: $("#theme-select").val()}, function(data){
			$.get("http://localhost/myapp/theme", {}, function(data){
				$("#output").html("");
				var output = "<div class='tab'>";
				var parsed = $.parseJSON(data);
				console.log(parsed);
				//$.parseJSON('{"OriginLocation":"JFK","DestinationLocation":"LAX","DepartureDateTime":"2015-03-03T00:00:00","ReturnDateTime":"2015-03-05T00:00:00","Forecast":{"HighestPredictedFare":832,"CurrencyCode":"USD","LowestPredictedFare":511},"Recommendation":"unknown","LowestFare":825.69,"CurrencyCode":"USD","Links":[{"rel":"self","href":"https://api.test.sabre.com/v1/forecast/flights/fares?origin=jfk&destination=LAX&departuredate=2015-03-03&returndate=2015-03-05"},{"rel":"linkTemplate","href":"https://api.test.sabre.com/v1/forecast/flights/fares?origin=&destination=&departuredate=&returndate="},{"rel":"shop","href":"https://api.test.sabre.com/v1/shop/flights?origin=JFK&destination=LAX&departuredate=2015-03-03&returndate=2015-03-05&pointofsalecountry=US"}]}');
				// for(var i = 0; i < parsed.Destinations.length; i++){
					// var item = parsed.Destinations[i];
					// output += "<p class='item'>Lowest Non-Stop Fare: $" + item.LowestNonStopFare + "; Lowest Overall Fare: $" + item.LowestFare + "</p>";
					// output += "<br/>";
					// output += "<p class='item'>Departure Date/Time: " + item.DepartureDateTime + "; Return Date/Time: " + item.ReturnDateTime + "</p>";
					// output += "<br/>";
				// }
				for(var i = 0; i < parsed.Destinations.length; i++){
					var item = parsed.Destinations[i];
					if(item.Destination.Type == "Airport")
						output += "<p class='item'>" + "To: " + item.Destination.CityName + " in " + item.Destination.CountryName + "; Airport Name: " + item.Destination.AirportName + "</p>";
					else if(item.Destination.Type == "City")
						output += "<p class='item'>" + "To: " + item.Destination.MetropolitanAreaName + " in " + item.Destination.CountryName + "</p>";
					else
						output += "<p class='item'>This destination type isn't implemented yet- fire someone.</p>";
					output += "<br/>";
				}
				add(output + "</div>");
				$("body").animate({scrollTop: 600}, 500);
			});
		});
	});
	$("#idea-season-submit").click(function(){
		$("#idea-origin-theme-input").val("dfw");
		$("#theme-select").val("skiing");
		$("#idea-theme-submit").click();
	});
	$("#idea-price-submit").click(function(){
		$("#results").removeClass("zero-height");
		$("#results").addClass("full-height");
		$.get("http://localhost/myapp/setprice/", {id1: $("#idea-origin-input").val(), id2: $("#destination-input").val(), id3: $("#length").val(), id4: $("#max-price").val()}, function(data){
			$.get("http://localhost/myapp/fare", {}, function(data){
				$("#output").html("");
				var output = "<div class='tab'>";
				var parsed = $.parseJSON(data);
				console.log(parsed);
				//$.parseJSON('{"OriginLocation":"JFK","DestinationLocation":"LAX","DepartureDateTime":"2015-03-03T00:00:00","ReturnDateTime":"2015-03-05T00:00:00","Forecast":{"HighestPredictedFare":832,"CurrencyCode":"USD","LowestPredictedFare":511},"Recommendation":"unknown","LowestFare":825.69,"CurrencyCode":"USD","Links":[{"rel":"self","href":"https://api.test.sabre.com/v1/forecast/flights/fares?origin=jfk&destination=LAX&departuredate=2015-03-03&returndate=2015-03-05"},{"rel":"linkTemplate","href":"https://api.test.sabre.com/v1/forecast/flights/fares?origin=&destination=&departuredate=&returndate="},{"rel":"shop","href":"https://api.test.sabre.com/v1/shop/flights?origin=JFK&destination=LAX&departuredate=2015-03-03&returndate=2015-03-05&pointofsalecountry=US"}]}');
				for(var i = 0; i < parsed.Destinations.length; i++){
					var item = parsed.Destinations[i];
					output += "<p class='item'>Lowest Non-Stop Fare: $" + item.LowestNonStopFare + "; Lowest Overall Fare: $" + item.LowestFare + "</p>";
					output += "<br/>";
					output += "<p class='item'>Departure Date/Time: " + item.DepartureDateTime + "; Return Date/Time: " + item.ReturnDateTime + "</p>";
					output += "<br/>";
				}
				// for(var i = 0; i < parsed.Destinations.length; i++){
					// var item = parsed.Destinations[i];
					// if(item.Destination.Type == "Airport")
						// output += "<p class='item'>" + "To: " + item.Destination.CityName + " in " + item.Destination.CountryName + "; Airport Name: " + item.Destination.AirportName + "</p>";
					// else if(item.Destination.Type == "City")
						// output += "<p class='item'>" + "To: " + item.Destination.MetropolitanAreaName + " in " + item.Destination.CountryName + "</p>";
					// else
						// output += "<p class='item'>This destination type isn't implemented yet- fire someone.</p>";
					// output += "<br/>";
				// }
				add(output + "</div>");
				$("body").animate({scrollTop: 600}, 500);
			});
		});
	});
	$("#theme_button").click(function(){
		$("#theme_input").removeClass("zero-height");
		$("#theme_input").addClass("full-height");
		$("#season_input").removeClass("full-height");
		$("#season_input").addClass("zero-height");
		$("#price_input").removeClass("full-height");
		$("#price_input").addClass("zero-height");
		window.setTimeout(function(){
		    $("body").animate({scrollTop: 465}, 500);
		}, 500);
	});
	$("#season_button").click(function(){
		$("#theme_input").removeClass("full-height");
		$("#theme_input").addClass("zero-height");
		$("#season_input").removeClass("zero-height");
		$("#season_input").addClass("full-height");
		$("#price_input").removeClass("full-height");
		$("#price_input").addClass("zero-height");
		window.setTimeout(function(){
		    $("body").animate({scrollTop: 465}, 500);
		}, 500);
	});
	$("#price_button").click(function(){
		$("#theme_input").removeClass("full-height");
		$("#theme_input").addClass("zero-height");
		$("#season_input").removeClass("full-height");
		$("#season_input").addClass("zero-height");
		$("#price_input").removeClass("zero-height");
		$("#price_input").addClass("full-height");
		window.setTimeout(function(){
		    $("body").animate({scrollTop: 465}, 500);
		}, 500);
	});
});
//$.get("page.jsp?date_begin=2015-02-28");
function add(data){
	$("#output").append(data);
}