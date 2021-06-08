//给定一个文件 file.txt，转置它的内容。 
//
// 你可以假设每行列数相同，并且每个字段由 ' ' 分隔。 
//
// 
//
// 示例： 
//
// 假设 file.txt 文件内容如下： 
//
// 
//name age
//alice 21
//ryan 30
// 
//
// 应当输出： 
//
// 
//name alice ryan
//age 21 30
// 
// 👍 50 👎 0


//There is no code of Java type for this problem

column=`cat file.txt | head -n 1| wc -w`
        for i in `seq 1 $column`
        do
        awk '{print $'''$i'''}' file.txt | xargs
        done