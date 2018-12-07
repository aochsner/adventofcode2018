package main

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestIt(t *testing.T) {
	assert.Equal(t, calculate([]string{"+1", "-1"}), 0)
}

