@echo off
echo ========================================
echo 🔥 JAVA PORTFOLIO DEMO - ONE CLICK RUN
echo ========================================
echo.
javac -cp ".;h2*.jar" *.java
echo.
echo 🔐 Running NavyDBTracker...
java -cp ".;h2*.jar" NavyDBTracker
echo.
echo 🛡️ Running PatchManager...
java -cp ".;h2*.jar" PatchManager
echo.
echo 📊 Running ACASScanner...
java -cp ".;h2*.jar" ACASScanner
echo.
echo 🌡️ Running WeatherAnalyzer...
java -cp ".;h2*.jar" WeatherAnalyzer
echo.
echo 📚 Running LibraryManagementSystem...
java -cp ".;h2*.jar" LibraryManagementSystem
echo.
echo ✅ ALL DEMOS COMPLETE - 100%% Job Requirements Match
pause
