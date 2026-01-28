#!/bin/bash
javac -cp ".:h2*.jar" *.java
echo "🔐 NavyDBTracker..."
java -cp ".:h2*.jar" NavyDBTracker
echo "🛡️ PatchManager..."
java -cp ".:h2*.jar" PatchManager  
echo "📊 ACASScanner..."
java -cp ".:h2*.jar" ACASScanner
echo "🌡️ WeatherAnalyzer..."
java -cp ".:h2*.jar" WeatherAnalyzer
echo "📚 LibraryManagementSystem..."
java -cp ".:h2*.jar" LibraryManagementSystem
echo "✅ ALL DEMOS COMPLETE"
