package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"strconv"
)

func scanFile(file string) []string {
	f, err := os.Open(file)
	if err != nil {
		log.Fatalf("open file error: %v", err)
	}
	defer f.Close()

	var lines []string
	sc := bufio.NewScanner(f)
	for sc.Scan() {
		lines = append(lines, sc.Text())
	}
	if err := sc.Err(); err != nil {
		log.Fatalf("scan file error: %v", err)
	}
	return lines
}

func main() {
	lines := scanFile("day1/input")
	result := calculate(lines)
	fmt.Println(result)
}

func calculate(lines []string) int {
	result := 0
	for _, line := range lines {
		value, err := strconv.Atoi(line)
		if err != nil {
			log.Fatalf("can't convert string to int")
		}
		result += value
	}
	return result
}
