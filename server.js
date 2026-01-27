const express = require('express');
const { execSync } = require('child_process');
const path = require('path');
const app = express();

app.use(express.static('.'));

// Run Java programs
app.get('/api/run/:program', (req, res) => {
    try {
        const program = req.params.program;
        const validPrograms = ['ACASScanner', 'NavyDBTracker', 'PatchManager'];
        
        if (!validPrograms.includes(program)) {
            return res.status(400).json({ error: 'Invalid program' });
        }
        
        const javaDir = path.join(__dirname, 'java-portfolio');
        const output = execSync(`cd ${javaDir} && java ${program}`, {
            encoding: 'utf-8',
            maxBuffer: 10 * 1024 * 1024
        });
        
        res.json({ success: true, output: output });
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

const PORT = 3000;
app.listen(PORT, () => {
    console.log(`Server running on http://localhost:${PORT}`);
});
