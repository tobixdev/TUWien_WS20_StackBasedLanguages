function setUpperBound([string] $upperBound) {
    $compiled_file = "prime_sieve.ps"
    $temp_file = Get-Content $compiled_file
    $temp_file[0] = $upperBound
    $temp_file | Set-Content $compiled_file
}

$upperBounds = @("1000", "100000", "500000", "1000000", "10000000")

# PostScript
for ($i=0; $i -lt $upperBounds.length; $i++){
    $currentBound = $upperBounds[$i]
    Write-Host "Executing PostScript file for n = $($currentBound) " -NoNewline
    setUpperBound $currentBound
    
    $elapsedTimeSpan = Measure-Command { gswin64c.exe .\runtime.ps .\prime_sieve.ps > $null }
    Write-Host "[took $($elapsedTimeSpan.TotalSeconds)]"
}

""

# Java
javac .\prime_sieve.java
for ($i=0; $i -lt $upperBounds.length; $i++){
    $currentBound = $upperBounds[$i]
    Write-Host "Executing Java file for n = $($currentBound) " -NoNewline
    
    $elapsedTimeSpan = Measure-Command { java prime_sieve $currentBound > $null }
    Write-Host "[took $($elapsedTimeSpan.TotalSeconds)]"
}