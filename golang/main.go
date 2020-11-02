package main

import (
	"crypto/md5"
	"fmt"
)

func main() {
	h := md5.New()
	fmt.Printf("%x", h.Sum(nil))
}
