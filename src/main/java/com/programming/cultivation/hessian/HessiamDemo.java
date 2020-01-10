package com.programming.cultivation.hessian;

import com.caucho.hessian.io.*;
import com.programming.cultivation.base.Book;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author biyue
 * @since 2020/01/09
 */
public class HessiamDemo {


    public static void main(String[] args) throws Exception {
        Book hello = new Book(1, "hello");
        byte[] serialize = serialize(hello);

        Object deserialize = deserialize(serialize);
        System.out.println(deserialize);


    }

    /**
     * Hessian实现序列化
     *
     * @param book
     * @return
     * @throws IOException
     */
    public static byte[] serialize(Object book) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        HessianOutput hessianOutput = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            // Hessian的序列化输出
            hessianOutput = new HessianOutput(byteArrayOutputStream);
            hessianOutput.writeObject(book);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                hessianOutput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Hessian实现反序列化
     *
     * @param employeeArray
     * @return
     */
    public static Object deserialize(byte[] employeeArray) {
        ByteArrayInputStream byteArrayInputStream = null;
        HessianInput hessianInput = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(employeeArray);
            // Hessian的反序列化读取对象
            hessianInput = new HessianInput(byteArrayInputStream);
            return hessianInput.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                byteArrayInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                hessianInput.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
