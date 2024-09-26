git pull origin main
git add .
git commit -m "$(powershell -Command Get-Date -Format 'yyyy-MM-dd')"
git push origin main

pause