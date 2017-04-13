package com.fz.mybatis.common;

import com.fz.mybatis.domain.Page;

import java.util.List;

/**
 * Created by Administrator on 2017/4/12.
 */
public interface BaseDao<T> {
    /**
     * �����¼
     */
    public Integer insert(T t);

    /**
     * ��������
     */
    public Integer insertBatch(List<T> models);

    /**
     * ����ID, ɾ����¼
     *
     * @return �Ƿ�����ɹ�. true:ɾ���ɹ�, false:ɾ��ʧ��
     */
    public Boolean deleteById(Integer id);


    /**
     * ���Ӽ�¼����, ɾ����¼
     *
     * @param t ����
     * @return �Ƿ�����ɹ�. true:ɾ���ɹ�, false:ɾ��ʧ��
     */
    public Boolean deleteByCon(T t);

    /**
     * ���¶���
     * @param t Ŀ�����
     * @return ��������
     */
    public Integer updateById(T t, Integer id);

    /**
     * ���¶���
     *
     * @param source ԭ����
     * @param target Ŀ�����
     * @return ��������
     */
    public Integer updateByCon(T source, T target);

    /**
     * ���Ҽ�¼
     *
     * @return ���ҽ��, δ�ҵ�����null
     */
    public T findOne(Integer id);

    /**
     * ���Ҽ�¼
     *
     * @param t ��������
     * @return ���ҽ��, δ�ҵ�����null
     */
    public T findOne(T t);

    /**
     * ��ѯ��¼
     *
     * @param t ��������
     * @return ���ҽ��, δ�ҵ�����null
     */
    public List<T> findMany(T t);

    /**
     * ��ȡ��¼����
     *
     * @return ��¼����
     */
    public Integer total();

    /**
     * ��ȡ��¼����
     *
     * @param t ��������
     * @return ��¼����
     */
    public Integer total(T t);

    /**
     * ��ҳ��ѯ
     * @param page ��ҳ����
     * @return
     */
    public Page queryPage(Page<T> page);
}
