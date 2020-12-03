(function() {
  var darkSwitch = document.getElementById("darkSwitch");
  if (darkSwitch) {
    initTheme();
    darkSwitch.addEventListener("change", function(event) {
      resetTheme();
    });
    function initTheme() {
      var darkThemeSelected =
        localStorage.getItem("darkSwitch") !== null &&
        localStorage.getItem("darkSwitch") === "dark";
      darkSwitch.checked = darkThemeSelected;
      darkThemeSelected
        ? document.body.setAttribute("class", "bootstrap-dark")
        : document.body.setAttribute("class", "bootstrap");
    }
    function resetTheme() {
      if (darkSwitch.checked) {
        document.body.setAttribute("class", "bootstrap-dark");
        localStorage.setItem("darkSwitch", "dark");
      } else {
        document.body.setAttribute("class", "bootstrap");
        localStorage.removeItem("darkSwitch");
      }
    }
  }
})();
